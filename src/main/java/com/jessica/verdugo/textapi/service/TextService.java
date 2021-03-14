package com.jessica.verdugo.textapi.service;

import com.jessica.verdugo.textapi.model.OutputModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.TreeMap;

public interface TextService  {

    OutputModel outputModelCreate(URL url) throws IOException;

}
