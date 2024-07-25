const { createServer } = require("http");
const url = require("url");
const axios = require("axios");

(async () => {
    const { default: chalk } = await import("chalk");

    const headers = {
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET",
    };

    const server = createServer((req, res) => {
        const requestURL = url.parse(req.url);
        const decodedParams = decodeParams(
            new URLSearchParams(requestURL.search)
        );
        const { search } = decodedParams;
        const targetURL = `https://api.api-ninjas.com/v1/recipe?query=${search}`; // API endpoint
        const apiKey = "YOUR_API_KEY"; // Replace with your actual API key

        if (req.method === "GET") {
            console.log(chalk.green(`Proxy GET request to: ${targetURL}`));
            axios
                .get(targetURL, { headers: { "X-Api-Key": apiKey } }) // Include API key in the headers
                .then((response) => {
                    res.writeHead(200, headers);
                    res.end(JSON.stringify(response.data));
                })
                .catch((error) => {
                    console.log(chalk.red(error));
                    res.writeHead(500, headers);
                    res.end(JSON.stringify({ error: "Internal Server Error" }));
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
})();
