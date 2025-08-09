# Инструкция по запуску

Запустите сервисы в следующем порядке:

user-service (порт 8081)

order-service (порт 8082)

bff-service (порт 8080)


# Запуск user-service
./gradlew :user-service:bootRun
http://localhost:8081/api/users/1

# Запуск order-service
./gradlew :order-service:bootRun
http://localhost:8082/api/orders/by-user/1

# Запуск bff-service
./gradlew :bff-service:bootRun
http://localhost:8080/api/site-bff/user/1


Для тестирования отправьте GET запрос на:

http://localhost:8080/api/site-bff/user/1