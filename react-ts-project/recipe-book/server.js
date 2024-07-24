import { createServer } from "http";
import url from "url";
import axios from "axios";
import chalk from "chalk";

const headers = {
    "Content-Type": "application/json",
    "Access-Control-Allow-Origin": "*",
    "Access-Control-Allow-Methods": "GET",
};

const server = createServer((req, res) => {
    const requestURL = url.parse(req.url);
    const decodedParams = decodeParams(new URLSearchParams(requestURL.search));
    const { search } = decodedParams;
    const targetURL = `http://www.recipepuppy.com/api/?q=${search}`;

    if (req.method === "GET") {
        console.log(chalk.green(`Proxy GET request to : ${targetURL}`));
        axios
            .get(targetURL)
            .then((response) => {
                res.writeHead(200, headers);
                res.end(JSON.stringify(response.data));
            })
            .catch((error) => {
                console.log(chalk.red(error.message));
                res.writeHead(500, headers);
                res.end(JSON.stringify({ error: error.message }));
            });
    }
});

server.listen(3001, () => {
    console.log(chalk.green("Server listening on port 3001"));
});

const decodeParams = (searchParams) =>
    Array.from(searchParams.keys()).reduce(
        (acc, key) => ({ ...acc, [key]: searchParams.get(key) }),
        {}
    );
