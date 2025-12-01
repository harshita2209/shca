import { createTheme, MantineProvider } from '@mantine/core';
import '@mantine/core/styles.css';
import '@mantine/notifications/styles.css';
import './App.css';
import AppRoutes from './Routes/AppRoutes';
import { Notifications } from '@mantine/notifications';
import { Provider } from 'react-redux';
import Store from './Store';


const theme = createTheme(
  {
    colors: {
      
      primary: [
        '#f1fafa','#dbf1f2','#bce2e5', '#8eccd2', '#58aeb8','#3c929e','#357985', '#30626e', '#2e535c', '#2a464f','#1b333b'
      ],
      neutral: [
        '#f6f6f6','#e7e7e7','#d1d1d1','#b0b0b0','#888888','#6d6d6d','#5d5d5d','#4f4f4f','#454545','#3d3d3d','#00000000'
      ]
    },
    fontFamily:"Poppins, sans-serif",
    primaryColor: "primary",
    headings:{fontFamily:"Merriweather,serif"},
    primaryShade: 4, //  '#58aeb8',
   
    defaultGradient:{
      from:"primary.4",
      to:"primary.8",
      deg:180
    }


  });

function App() {
  return (
    <Provider store={Store}>
    <MantineProvider theme={theme}>
      <Notifications position='top-center' />
      <AppRoutes />
    </MantineProvider>
    </Provider>
  );
}

export default App;
