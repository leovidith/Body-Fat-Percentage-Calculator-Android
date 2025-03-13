# Body Fat Percentage Calculator

## Overview

The **Body Fat Percentage Calculator** app allows users to calculate their body fat percentage, lean body mass, and fat body mass based on basic physical measurements. The app is simple and easy to use, providing immediate results after entering values for age, weight, height, neck circumference, waist circumference, and hip circumference (for females).

## Working of the App

The app uses the **Body Fat Percentage Formula** to calculate the body fat percentage for both males and females. The formula is based on the user's waist, neck, and height measurements. For females, the hip circumference is also included.

### **Formulae**:

- **For Males**:  
  `Body Fat Percentage = 495 / (1.0324 - 0.19077 * log10(waist - neck) + 0.15456 * log10(height)) - 450`

- **For Females**:  
  `Body Fat Percentage = 495 / (1.29579 - 0.35004 * log10(waist + hip - neck) + 0.22100 * log10(height)) - 450`

### **Steps**:

1. The user enters their age, weight, height, neck circumference, and waist circumference into the input fields.
2. If the user selects "Female," they will also need to enter their hip circumference.
3. After filling in the required information, the user taps on the **Calculate Body Fat** button.
4. A progress bar appears while the app calculates the body fat percentage (with a 3-second delay to simulate processing).
5. After the calculation, the app displays:
   - **Body Fat Percentage**
   - **Lean Body Mass** (Weight minus Fat Body Mass)
   - **Fat Body Mass** (Calculated as Body Fat Percentage of total weight)
6. The app provides an error message if any inputs are invalid or missing.

## Steps to Install APK

To run the app on an Android device, follow these steps:

### Prerequisites:
- **Android Studio**: Make sure you have **Android Studio** installed on your machine.
- **Android Device or Emulator**: You can run the APK on a physical Android device or use an Android emulator.

### Steps:
1. **Clone the Repository**:  
   Clone this repository to your local machine using the command:  
   ```bash
   git clone <https://github.com/leovidith/Body-Fat-Percentage-Calculator-Android>
   ```

2. **Open the Project**:  
   Open the project folder in **Android Studio**.

3. **Build the Project**:  
   Build the project by clicking on the **Build** menu in Android Studio, then **Make Project**. This ensures all dependencies are resolved and the app is built correctly.

4. **Install the APK**:  
   - Connect your Android device via USB or start an emulator.
   - Run the app by clicking the **Run** button (green play button) in Android Studio. Select your device or emulator.

5. **Run the App**:  
   Once installed, open the app on your Android device. You can start entering values to calculate your body fat percentage!

### Alternative: Direct APK Installation
If you already have the APK built, you can manually install it on your device:
1. Copy the APK file to your Android device.
2. Enable **Install from unknown sources** in your device settings.
3. Tap on the APK file to install it.

## Dependencies
- **Material Components**: For TextInputLayout, RadioButton, Button, etc.
- **Android SDK 29 or higher**: Ensure your project targets at least SDK 29 for compatibility.

## License

This project is open-source and available under the [MIT License](LICENSE).
