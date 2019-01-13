package com.neelk.dvhacks;

import android.graphics.Bitmap;

import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class WolframCloudCall {

    public static String call(Bitmap personPic) throws IOException {

        URL _url = new URL("https://www.wolframcloud.com/objects/4b8688d9-c1ae-4c33-88a5-64814792ec50");
        HttpURLConnection _conn = (HttpURLConnection) _url.openConnection();
        _conn.setRequestMethod("POST");
        _conn.setDoOutput(true);
        _conn.setDoInput(true);
        _conn.setUseCaches(false);
        _conn.setAllowUserInteraction(false);
        _conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=92afc99d-494c-41aa-8f16-2febb8b310dd");
        _conn.setRequestProperty("User-Agent", "EmbedCode-Java/1.0");
        DataOutputStream _out = new DataOutputStream(_conn.getOutputStream());

        _out.writeBytes("--92afc99d-494c-41aa-8f16-2febb8b310dd\r\n");
        _out.writeBytes("Content-Disposition: form-data; name=\"personPic\"\r\n");
        _out.writeBytes("Content-Type: application/octet-stream\r\n\r\n");
        //write a bitmap to a stream
        //writing bytes of image to stream
        //find a way to write a
      //  javax.imageio.write(personPic, "png", _out);
        _out.writeBytes("\r\n");

        _out.writeBytes("--92afc99d-494c-41aa-8f16-2febb8b310dd--\r\n");


        _out.close();

        if (_conn.getResponseCode() != 200) {
            throw new IOException(_conn.getResponseMessage());
        }
        
        BufferedReader _rdr = new BufferedReader(new InputStreamReader(_conn.getInputStream()));
        StringBuilder _sb = new StringBuilder();
        String _line;
        while ((_line = _rdr.readLine()) != null) {
            _sb.append(_line);
        }
        _rdr.close();
        _conn.disconnect();
        return _sb.toString();
    }
}
