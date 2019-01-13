package com.neelk.dvhacks;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

public class WolframCloudCall extends AsyncTask<Bitmap, Void, String> {

    @Override
    protected String doInBackground(Bitmap... personPic) {
        try{
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

            ByteArrayOutputStream streamer = new ByteArrayOutputStream();
            personPic[0].compress(Bitmap.CompressFormat.PNG, 75, streamer);
            byte[] streamData = streamer.toByteArray();
            Log.d("Sure", Base64.getEncoder().encodeToString(streamData));
            _out.write(streamData,0,streamData.length);

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
            System.out.println(_sb.toString());
            return _sb.toString();
        }
        catch (IOException e){
            e.printStackTrace();
            return "";
        }
    }

    @Override
    protected void onPostExecute(String result){
        resulted(result);
    }

    private String resulted(String resulter){
        return resulter;
    }
}
