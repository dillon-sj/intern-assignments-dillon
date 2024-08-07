import React from "react";
import NavBar from "../components/NavBar";
import "./HomePage.css";
import { Link } from "react-router-dom";

const HomePage = () => {
    return (
        <div className="full-page-div">
            <NavBar />
            <div className="main-title">
                Welcome to the <br />
                <span className="brand-name">API Explorer</span>
            </div>
            <div className="btn-holder">
                <div className="request-table">
                    <div className="request-title">Get Request</div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/getAllEmployeesPage"}>
                                    <button className="link-name">
                                        Get All Employees
                                    </button>
                                </Link>
                            </li>
                            <li className="list-content-style">
                                <Link to={"/getEmployeeByIdPage"}>
                                    <button className="link-name">
                                        Get Employee By ID
                                    </button>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>

                <div className="request-table">
                    <div className="request-title">Post Request</div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/getAllEmployeesPage"}>
                                    <button className="link-name">
                                        Get Employee By ID
                                    </button>
                                </Link>
                            </li>
                            <li className="list-content-style">
                                <Link to={"/getEmployeeByIdPage"}>
                                    <div>
                                        <button className="link-name">
                                            Get Employee By ID
                                        </button>
                                    </div>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
                <div className="request-table">
                    <div className="request-title">Delete Request</div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/getAllEmployeesPage"}>
                                    <button className="link-name">
                                        Get Employee By ID
                                    </button>
                                </Link>
                            </li>
                            <li className="list-content-style">
                                <Link to={"/getEmployeeByIdPage"}>
                                    <button className="link-name">
                                        Get Employee By ID
                                    </button>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default HomePage;
