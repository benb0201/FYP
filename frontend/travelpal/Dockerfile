FROM node:21-slim AS base
ENTRYPOINT ["/usr/local/bin/npm"]

# install dependencies
FROM base AS deps
WORKDIR /app
ADD package*.json .
RUN npm install

# dev server
FROM base AS dev
WORKDIR /app
COPY --from=deps /app/node_modules ./node_modules
COPY . .
EXPOSE 3000
CMD ["run", "start"]

# builder, required for the prodtest target
FROM dev AS builder
ARG REACT_APP_BACKEND_URL
ARG PUBLIC_URL
RUN npm run build

# prodtest server
FROM nginx:stable-alpine AS prodtest
ARG PUBLIC_URL
COPY --from=builder /app/build /usr/share/nginx/html/${PUBLIC_URL}/
COPY nginx/default.conf /etc/nginx/conf.d/default.conf
