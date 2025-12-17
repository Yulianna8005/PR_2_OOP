package com.yuko;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.List;

/**
 * Контролер для обробки запитів, пов'язаних з виловом.
 * Звертається до сервісу (моделі) для отримання даних.
 */
@Singleton
public class CatchController {
    private final CatchLogService catchLogService;

    @Inject
    public CatchController(CatchLogService catchLogService) {
        this.catchLogService = catchLogService;
    }

    /**
     * Отримати список усіх записів вилову.
     */
    public List<CatchEntry> getAllCatches() {
        return catchLogService.getAllCatches();
    }
}