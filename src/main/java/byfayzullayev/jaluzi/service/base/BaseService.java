package byfayzullayev.jaluzi.service.base;

import byfayzullayev.jaluzi.model.response.ApiResponse;

public interface BaseService {

    ApiResponse SUCCESS = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse SUCCESS_V2 = new ApiResponse("muvafaqiyatli bajarildi", true, 0);
    ApiResponse USER_EXIST = new ApiResponse("bu username allaqachon mavjud", false, -100);
    ApiResponse USER_NOT_FOUND = new ApiResponse("bu user topilmadi", false, -101);
    ApiResponse ERROR_CATEGORY_NOT_FOUND = new ApiResponse(" category bo'lim topilmadi",false,-101);
    ApiResponse ERROR_PRODUCT_NOT_FOUND = new ApiResponse(" product topilmadi", false, -101);
    ApiResponse ERROR_FILE_CREATE = new ApiResponse("rasm saqlashda xatolik, base64 tekshir", false, -101);
    ApiResponse ERROR_DELETE = new ApiResponse("o`chirishda xatolik", false, -101);
}



