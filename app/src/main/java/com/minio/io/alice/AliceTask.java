/*
 * Copyright (c) 2017 Minio, Inc. <https://www.minio.io>
 *
 * This file is part of Alice.
 *
 * Alice is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.minio.io.alice;

import android.os.AsyncTask;

/**
 * AsyncTask that sends the video buffer over to the Xray Server.
 */

public class AliceTask extends AsyncTask<Void, Integer, String> {


    byte[] bufmat;
    String data;
    boolean textPayload = false;

    public AliceTask(byte[] buf) {
        bufmat = buf;
    }

    public AliceTask(String data) {
        this.data = data;
        this.textPayload = true;
    }
    @Override
    protected void onPreExecute() {

    }

    @Override
    protected String doInBackground(Void ... params) {

        if(MainActivity.webSocket != null) {
            if (textPayload)
                MainActivity.webSocket.sendPayload(data);
            else
                MainActivity.webSocket.sendPayload(bufmat);
        }
        bufmat = null;
        return String.valueOf(R.string.COMPLETE);

    }

    @Override
    protected void onCancelled() {

    }

    protected void onPostExecute(String finish) {

    }
}
