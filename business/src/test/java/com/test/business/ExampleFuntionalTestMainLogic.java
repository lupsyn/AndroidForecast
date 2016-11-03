package com.test.business;


import com.test.business.controller.ILoggerController;
import com.test.business.controller.location.ILocationController;
import com.test.business.controller.network.INetworkController;
import com.test.business.controller.network.WeatherCallback;
import com.test.business.entity.Response;
import com.test.business.view.MainView;

import org.junit.Test;
import org.testng.reporters.jq.Main;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Copyright (c) 2016.
 *
 * @author enricodelzotto
 */
public class ExampleFuntionalTestMainLogic {
    //In this layer (the most important one)  test on logic are expected, not only plain unit tests
    //With this design-pattern we can test logic in a separate context from android,
    //for absurd the same code can run in a different os.
    //We for example we can write the same code in different languages (c++ for example)
    //compiling as .so and running through jni but the final result should be the same.
    //With this approch, we can write logic in complex app once a time, (as in c++ core case)
    //and running in different os (iOS,etc).
    //These are simple example on how to tests this layer.

    //In the data layer also unit tests are expected.

    @Test
    public void testIfConstructorParametersAreValid() {
        int exceptions = 0;
        try {
            MainLogic mainLogic = MainLogic.getInstance();
            mainLogic.setControllers(new NetworkControllerMock(), new LoggerControllerMock(), new LocationControllerMock());
        } catch (InvalidParameterException e) {
            exceptions++;
        }
        assertEquals(exceptions, 0);

    }

    //Have we the right error handling?
    @Test
    public void testIfConstructorParametersAreInvalid() {
        int exceptions = 0;
        try {
            MainLogic mainLogic = MainLogic.getInstance();
            mainLogic.setControllers(null, null, null);
        } catch (InvalidParameterException e) {
            exceptions++;
        }
        assertEquals(exceptions, 1);

    }

    //Example of test based on behaviour. (bdd)

    @Test
    public void testIfLocationIsAsked() {
        MainLogic mainLogic = MainLogic.getInstance();

        INetworkController mockNetworkController = mock(INetworkController.class);
        ILoggerController loggerController = new LoggerControllerMock();
        ILocationController locationController = new LocationControllerMock();
        mainLogic.setControllers(mockNetworkController, loggerController, locationController);
        MainView view = mock(MainView.class);
        mainLogic.onMainViewCreated(view);
        verify(mockNetworkController, times(1));


    }
}
