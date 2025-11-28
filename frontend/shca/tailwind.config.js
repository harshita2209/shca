/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,jsx,ts,tsx}"],
  theme: {
    extend: {

      fontFamily:{
        body: 'Poppins, sans-serif',
        sans: 'Poppins,sans-serif',
        heading: 'Merriweather,serif'
      },

      
      colors: {
        pimary: {
          50: "#f1fafa",
          100: "#dbf1f2",
          200: "#bce2e5",
          300: "#8eccd2",
          400: "#58aeb8",
          500: "#3d929d",
          600: "#357785",
          700: "#30626e",
          800: "#2e525c",
          900: "#2a464f",
          950: "#182d34",
        },
        neutral: {
          50: "#f6f6f6",
          100: "#e7e7e7",
          200: "#d1d1d1",
          300: "#b0b0b0",
          400: "#888888",
          500: "#6d6d6d",
          600: "#5d5d5d",
          700: "#4f4f4f",
          800: "#454545",
          900: "#3d3d3d",
          950: "#000000",
        },
        dark:"#212529",
        light:"#F0F0FB"
      },
    },
  },
  plugins: [],
}

