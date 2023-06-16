# Spring Cloud: интеграция с внешними веб сервисами на примере Feign Client
## План
1. Создадим микросервис , который будет отдавать по POST запросу
   http://localhost:8080/api/weather текущую погоду , в зависимости от передаваемых в метод данных
в JSON формате :
```json
{"longitude": 20.2, "latitude": 30.10, "date": "2023-05-23T10:20:00"}
```
2. Расширим функционал при помощи интеграции с другим сервисом получения данных о погоде
3. Настроим FeignClient для улучшения показателей доступности и отказоустойчивости .
Продемонстрируем практическое применение микросервисных шаблонов