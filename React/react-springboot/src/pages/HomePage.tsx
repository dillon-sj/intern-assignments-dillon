import React from "react";
import { Link } from "react-router-dom";
import "./pageStyle.css";

const HomePage = () => {
    return (
        <div className="full-page-div">
            <div className="main-title">
                Welcome to the <br />
                <span className="brand-name">API Explorer</span>
            </div>
            <div className="btn-holder">
                <div className="request-table">
                    <div className="request-title get-title ">Get Request</div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/getAllEmployeesPage"}>
                                    <button className="link-name get-request">
                                        Get All Employees
                                    </button>
                                </Link>
                            </li>
                            <li className="list-content-style">
                                <Link to={"/getEmployeeByIdPage"}>
                                    <button className="link-name get-request ">
                                        Get Employee By ID
                                    </button>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>

                <div className="request-table">
                    <div className="request-title post-title ">
                        Post Request
                    </div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/postEmployee"}>
                                    <button className="link-name post-resquest ">
                                        Post Employee
                                    </button>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
                <div className="request-table">
                    <div className="request-title delete-title ">
                        Delete Request
                    </div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/deleteEmployee"}>
                                    <button className="link-name delete-request ">
                                        Delete Employee By ID
                                    </button>
                                </Link>
                            </li>
                        </ul>
                    </div>
                </div>
                <div className="request-table">
                    <div className="request-title Put-title ">Put Request</div>
                    <div className="request-contents">
                        <ul className="list-style">
                            <li className="list-content-style">
                                <Link to={"/putEmployee"}>
                                    <button className="link-name put-request ">
                                        Put Employee By ID
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
