/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.tools.sjavac;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

/**
 * Utility class only for sjavac logging.
 *
 * Logging in sjavac has special requirements when running in server/client
 * mode. Most of the log messages is generated server-side, but the server
 * is typically spawned by the client in the background, so the user usually
 * does not see the server stdout/stderr. For this reason log messages needs
 * to relayed back to the client that performed the request that generated the
 * log message. To support this use case this class maintains a per-thread log
 * instance so that each connected client can have its own instance that
 * relays messages back to the requesting client.
 *
 * On the client-side (or when running sjavac without server-mode) there will
 * typically just be one Log instance.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Log {

    public enum Level {
        ERROR,
        WARN,
        INFO,
        DEBUG,
        TRACE;
    }

    private static Log stdOutErr = new Log(new PrintWriter(System.out), new PrintWriter(System.err));
    private static ThreadLocal<Log> loggers = new ThreadLocal<>();

    protected PrintWriter err; // Used for error and warning messages
    protected PrintWriter out; // Used for other messages
    protected Level level = Level.INFO;

    public Log(Writer out, Writer err) {
        this.out = out == null ? null : new PrintWriter(out, true);
        this.err = err == null ? null : new PrintWriter(err, true);
    }

    public static void setLogForCurrentThread(Log log) {
        loggers.set(log);
    }

    public static void setLogLevel(String l) {
        setLogLevel(Level.valueOf(l.toUpperCase(Locale.US)));
    }

    public static void setLogLevel(Level l) {
        get().level = l;
    }

    public static void trace(String msg) {
        log(Level.TRACE, msg);
    }

    public static void debug(String msg) {
        log(Level.DEBUG, msg);
    }

    public static void info(String msg) {
        log(Level.INFO, msg);
    }

    public static void warn(String msg) {
        log(Level.WARN, msg);
    }

    public static void error(String msg) {
        log(Level.ERROR, msg);
    }

    public static void error(Throwable t) {
        log(Level.ERROR, t);
    }

    public static void log(Level l, String msg) {
        get().printLogMsg(l, msg);
    }

    public static void debug(Throwable t) {
        log(Level.DEBUG, t);
    }

    public static void log(Level l, Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw, true));
        log(l, sw.toString());
    }

    public static boolean isDebugging() {
        return get().isLevelLogged(Level.DEBUG);
    }

    protected boolean isLevelLogged(Level l) {
        return l.ordinal() <= level.ordinal();
    }

    public static Log get() {
        Log log = loggers.get();
        return log != null ? log : stdOutErr;
    }

    protected void printLogMsg(Level msgLevel, String msg) {
        if (isLevelLogged(msgLevel)) {
            PrintWriter pw = msgLevel.ordinal() <= Level.WARN.ordinal() ? err : out;
            pw.println(msg);
        }
    }
}
