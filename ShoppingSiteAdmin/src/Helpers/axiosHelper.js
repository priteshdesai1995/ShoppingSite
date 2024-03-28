import axios from 'axios';

// axios.defaults.baseURL="http://localhost:8087";
axios.defaults.baseURL="http://localhost:8887";
// axios.defaults.headers.post["Content-type"]="application/json";
// axios.defaults.headers.get["Access-Control-Allow-Origin"]="*";
// axios.defaults.headers["Access-Control-Allow-Origin"] = "*";
// axios.defaults.headers["Access-Control-Allow-Methods"] = "GET, PUT, POST, DELETE, OPTIONS";
// axios.defaults.headers["Access-Control-Allow-Headers"] = "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range";
// axios.defaults.headers["Access-Control-Max-Age"] = "1728000";
// axios.defaults.headers["Access-Control-Expose-Headers"] = "DNT,X-CustomHeader,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Content-Range,Range";
export const request = (method, url, data) => {
    return axios({
        method: method,
        url: url,
        data: data
    })
}