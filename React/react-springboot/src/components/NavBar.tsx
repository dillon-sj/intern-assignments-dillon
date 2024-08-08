import React from "react";
import "./styles.css";
import { Link } from "react-router-dom";

const NavBar = () => {
    return (
        <div className="topper">
            <div className="holder">
                <p className="brand-name-navbar">API Explorer</p>
                <Link to={"/home"}>
                    <button className="home-btn">Home</button>
                </Link>
            </div>
        </div>
    );
};

export default NavBar;
