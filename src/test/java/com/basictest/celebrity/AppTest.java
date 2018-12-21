package com.basictest.celebrity;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.basictest.celebrity.logic.DataCelebrity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(App.class)
public class AppTest {

    private App app;

    @Mock
    DataCelebrity dataCelebrity;

    @Test
    public void mainTest() throws Exception {
        when(dataCelebrity.getCelebrityId(anyString())).thenReturn(-1);
        PowerMockito.whenNew(DataCelebrity.class).withAnyArguments().thenReturn(dataCelebrity);
        App.main(new String[] {" "});
        verify(dataCelebrity).getCelebrityId(anyString());

    }
}
