package com.nitingupta.xebiaassignment.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.nitingupta.xebiaassignment.Models.WeatherResultModel;
import com.nitingupta.xebiaassignment.Util.CommonUtil;
import com.nitingupta.xebiaassignment.interfaces.WeatherResultsLoaded;


public class ResultsProcessTask extends AsyncTask<Object, Integer, WeatherResultModel> {

    WeatherResultModel weatherResultModel;
    WeatherResultsLoaded resultLoaded;
    Context mContext;

    public ResultsProcessTask(Context context, WeatherResultsLoaded placesResultLoaded) {
        this.resultLoaded = placesResultLoaded;
        this.mContext = context;
    }

    @Override
    protected WeatherResultModel doInBackground(Object... inputObj) {

        try {
            weatherResultModel = (WeatherResultModel) CommonUtil.loadJSONFromString(mContext, (String) inputObj[0], WeatherResultModel.class);
        } catch (Exception e) {
            Log.d("Exception", e.toString());
        }
        return weatherResultModel;
    }

    @Override
    protected void onPostExecute(WeatherResultModel list) {
        resultLoaded.onResultLoaded(list);

    }
}
