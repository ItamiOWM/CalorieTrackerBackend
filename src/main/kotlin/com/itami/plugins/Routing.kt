package com.itami.plugins

import com.itami.routes.auth.auth
import com.itami.routes.food.food
import com.itami.routes.meal.meal
import com.itami.service.auth.AuthService
import com.itami.service.food.FoodService
import com.itami.service.meal.MealService
import io.ktor.server.application.*
import io.ktor.server.plugins.ratelimit.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val authService: AuthService by inject()
    val mealService: MealService by inject()
    val foodService: FoodService by inject()

    routing {
        get("/") {
            call.respondText("Welcome to Calorie Tracker!")
        }
        rateLimit(configuration = AUTH_RATE_LIMIT) {
            auth(authService = authService)
        }
        rateLimit(configuration = APP_RATE_LIMIT) {
            meal(mealService = mealService)
            food(foodService = foodService)
        }
    }
}
