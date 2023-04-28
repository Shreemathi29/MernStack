/*
 * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal.dcmd;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

import jdk.jfr.Recording;
import jdk.jfr.internal.PrivateAccess;
import jdk.jfr.internal.SecuritySupport.SafePath;
import jdk.jfr.internal.WriteableUserPath;

/**
 * JFR.stop
 *
 */
// Instantiated by native
final class DCmdStop extends AbstractDCmd {

    @Override
    protected void execute(ArgumentParser parser)  throws DCmdException {
        parser.checkUnknownArguments();
        String name = parser.getOption("name");
        String filename = expandFilename(parser.getOption("filename"));
        try {
            Recording recording = findRecording(name);
            WriteableUserPath path = PrivateAccess.getInstance().getPlatformRecording(recording).getDestination();
            SafePath safePath = path == null ? null : new SafePath(path.getRealPathText());
            if (filename != null) {
                try {
                    // Ensure path is valid. Don't generate safePath if filename == null, as a user may
                    // want to stop recording without a dump
                    safePath = resolvePath(null, filename);
                    recording.setDestination(Paths.get(filename));
                } catch (IOException | InvalidPathException  e) {
                    throw new DCmdException("Failed to stop %s. Could not set destination for \"%s\" to file %s", recording.getName(), filename, e.getMessage());
                }
            }
            recording.stop();
            reportOperationComplete("Stopped", recording.getName(), safePath);
            recording.close();
        } catch (InvalidPathException | DCmdException e) {
            if (filename != null) {
                throw new DCmdException("Could not write recording \"%s\" to file. %s", name, e.getMessage());
            }
            throw new DCmdException(e, "Could not stop recording \"%s\".", name, e.getMessage());
        }
    }

    @Override
    public String[] printHelp() {
            // 0123456789001234567890012345678900123456789001234567890012345678900123456789001234567890
        return """
               Syntax : JFR.stop [options]

               Options:

                 filename  (Optional) Name of the file to which the recording is written when the
                           recording is stopped. If no path is provided, the data from the recording
                           is discarded. (STRING, no default value)

                           Note: If a path is given, '%%p' in the path will be replaced by the PID,
                           and '%%t' will be replaced by the time in 'yyyy_MM_dd_HH_mm_ss' format.

                 name      Name of the recording (STRING, no default value)

               Options must be specified using the <key> or <key>=<value> syntax.

               Example usage:

                $ jcmd <pid> JFR.stop name=1
                $ jcmd <pid> JFR.stop name=benchmark filename=%s
                $ jcmd <pid> JFR.stop name=5 filename=recording.jfr

               """.formatted(exampleDirectory()).
               lines().toArray(String[]::new);
    }

    @Override
    public Argument[] getArgumentInfos() {
        return new Argument[] {
            new Argument("name",
                "Recording text,.e.g \\\"My Recording\\\"",
                "STRING", true, null, false),
            new Argument("filename",
                "Copy recording data to file, e.g. \\\"" + exampleFilename() +  "\\\"",
                "STRING", false, null, false)
        };
    }
}