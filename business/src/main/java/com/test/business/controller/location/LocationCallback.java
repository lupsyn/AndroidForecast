package com.test.business.controller.location;

import com.test.business.entity.Coordinates;

public interface LocationCallback {
    void onDetected(Coordinates location);

    void onPermissionMissing();

    void onError(String msg);
}
