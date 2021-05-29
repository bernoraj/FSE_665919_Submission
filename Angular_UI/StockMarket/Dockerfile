#stage1 build
FROM node:14 as node
WORKDIR /usr/src/app
COPY package*.json ./
RUN npm i npm@'6.14.10' -g
RUN npm install
COPY . .
RUN npm run build

#stage2 NGINX
FROM nginx
COPY --from=node /usr/src/app/dist/StockMarket /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf