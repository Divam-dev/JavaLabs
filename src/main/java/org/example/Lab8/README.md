# Лабораторна робота 8

## Функціональність програми:

Навчитися ефективно використовувати Java Streams для аналізу даних, отриманих через HTTP-запити. Взаємодіяти з реальним API для отримання метеорологічних даних.

## Опис роботи програми:

- Клас `MeasurmentLocation` містить властиовсті: `id`, `name`, `latitude`, `longitude`, `city`.
- Клас `WeatherApiFetcher` містить методи `getApiUrlForCity` та `performHttpRequest`, що дозволяють отримати дані з API.
- Клас `WeatherApiMapper` містить методи `processWeatherData` для обробки даних та інші для отримання значень.
- Клас `Histogram` містить метод `generateHistogram` для генерації гістограми.
- Клас `WeatherCalculations` відповідає за аналіз даних та виконання розрахунків.
- Клас `WeathrDemo` відповідає за демонстрацію роботи програми.

### Опис класів:

### `WeatherCalculations`:

- `calculateDailyAverageHumidity` розраховує середню вологість за день.
- `calculateMeanTemperature` розраховує середню температуру.
- `calculateAverageHumidity` розраховує середню вологість.
- `hasTemperatureIncreased` перевіряє чи збільшилась температура для розрахунку чи температура зросла на щонайменше на 5°C протягом 5 послідовних днів.
- `hasConsecutiveDaysWithPrecipitation` перевіряє чи є послідовні дні з опадами для розрахунку 7 послідовних днів опадів.
- `findMonthWithHighestAverage` знаходить місяць з найвищою середньою швидкістю вітру.
- `calculateAverage` розраховує середнє значення для вітру.

## Тестування:

- `testWeatherApiFetcher` тестує методи класу `WeatherApiFetcher`, які відповідають за отримання даниз з API.
- `testWeatherApiMapper` тестує методи класу `WeatherApiMapper`, які відповідають за обробку даних в правильний формат.
- `testCalculateDailyAverageHumidity` тестує методи класу `WeatherCalculations`, які відповідають за .
- `testCalculateMeanTemperature` тестує методи класу `WeatherDemo`, які відповідають за розрахунок середньої температури.
- `testCalculateAverageHumidity` тестує методи класу `WeatherDemo`, які відповідають за розрахунок середньої вологості за день.
- `testHasTemperatureIncreased` тестує методи класу `WeatherDemo`, які відповідають чи температура виросла.
- `testHasConsecutiveDaysWithPrecipitation` тестує методи класу `WeatherDemo`, які відповідають чи є послідовні дні з опадами.

