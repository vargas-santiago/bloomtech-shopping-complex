import React from 'react';
import {createRoot} from 'react-dom/client';
import './index.css';
import App from './App';
import * as root from "@testing-library/react";

const container = document.getElementById('root');

createRoot(container);

root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
);


