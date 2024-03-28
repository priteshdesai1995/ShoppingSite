import logo from './logo.svg';
import './App.css';
import Navigation from './customer/components/Navigation/Navigation';
import MainCarousel from './customer/components/HomeCarousel/MainCarousel';
import HomePage from './customer/pages/HomePage/HomePage';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<h1>Main Page</h1>}></Route>
          <Route path="/home" element={<h1>Second Page</h1>}></Route>
          <Route path="/newProducts" element={<h1>New Product is Called</h1>}></Route>
        </Routes>
      

      <div className="App">
        <div className='navDiv'>
          <Navigation />
        </div>
        <div className='homeDiv'>
          <HomePage />
        </div>
      </div>
      </BrowserRouter>

    </>
  );
}

export default App;
