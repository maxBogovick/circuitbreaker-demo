# Spring Cloud: Integration with External Web Services using Feign Client

## Plan

1. We'll create a microservice that responds to a POST request at `http://localhost:8080/api/weather` by providing the current weather. The response depends on the JSON data passed to the method:
   ```json
   {"longitude": 20.2, "latitude": 30.10, "date": "2023-05-23T10:20:00"}
   ```
2. Expand functionality by integrating with another weather data retrieval service.
3. Configure FeignClient to enhance accessibility and fault tolerance, demonstrating practical application of microservice patterns.
