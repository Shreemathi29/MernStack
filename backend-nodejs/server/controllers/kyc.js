// import express from 'express';
// import mongoose from 'mongoose';

// import KycModel from "../models/kyc.js";
// const router = express.Router();

// export const createform = async (req, res) => {
//     const { name, emailId, pancard, address, mobile, IncomeRange } = req.body;

//     const newcreateform = new KycModel({ name, emailId, pancard, address, mobile, IncomeRange })

//     try {
//         await newcreateform.save();

//         res.status(201).json(newcreateform );
//     } catch (error) {
//         res.status(409).json({ message: error.message });
//     }
// }
// export default router;