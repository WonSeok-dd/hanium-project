package org.techtown.chatbot1;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Inout_Fragment_Inout_barchart extends Fragment {
    ArrayList<String> labelList = new ArrayList<>();
    ArrayList<BarEntry> barentry = new ArrayList<>();
    Map<String,Integer> dataList;
    BarChart barChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup view =(ViewGroup) inflater.inflate(R.layout.fragment_inout_inout_barchart, container, false);
        barChart = (BarChart) view.findViewById(R.id.inout_inout_bc);
        Bundle inout_bundle = getArguments();
        Parceldata inout_data = inout_bundle.getParcelable("inout_data");
        dataList= inout_data.datalist;

        graphInitSetting();

        barChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {
                try{
                    int index = barChart.getData().getDataSetForEntry(e).getEntryIndex((BarEntry)e);
                    Object[] data_key = dataList.keySet().toArray();
                    Object[] data_value = dataList.values().toArray();

                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("입/출항");
                    builder.setMessage(data_key[index].toString()+"\n"+"해당 개수: "+data_value[index]);
                    builder.setCancelable(true);

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }catch (Exception error){
                    error.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected() {

            }
        });



        return view;
    }
    public void graphInitSetting(){

        Iterator data_key = dataList.keySet().iterator();
        LegendEntry[] legendEntries =new LegendEntry[dataList.size()];



        int i =0;
        float high=0;
        while(data_key.hasNext()){
            String in = data_key.next().toString();
            BarEntry data = new BarEntry(i,dataList.get(in).intValue());
            if(dataList.get(in).floatValue()>high){
                high = dataList.get(in).floatValue();
            }
            barentry.add(data);
            labelList.add(in);

            LegendEntry entry = new LegendEntry();
            entry.label = String.valueOf(in);
            entry.formColor = ColorTemplate.VORDIPLOM_COLORS[i];
            legendEntries[i] = entry;
            i++;
        }
        //그래프 설명,색깔 설정
        BarDataSet barDataSet = new BarDataSet(barentry, "");
        barDataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);
        barDataSet.setValueFormatter(new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return (int)value + "대";
            }
        });
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10f);
        //data로 만들기
        BarData data = new BarData(barDataSet);
        data.setBarWidth(0.9f);

        //라벨값 추가
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setAxisLineColor(Color.BLACK);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labelList));
        xAxis.setGranularity(1f);


        YAxis yl = barChart.getAxisLeft();
        yl.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yl.setDrawGridLines(false);
        yl.setAxisMinimum(0f);
        yl.setAxisMaximum(high+10f);
        yl.setDrawAxisLine(true);
        yl.setAxisLineColor(Color.BLACK);
        yl.setDrawLabels(true);
        yl.setValueFormatter(new ValueFormatter(){

            @Override
            public String getFormattedValue(float value) {
                return (int)value +"대";
            }
        });

        YAxis yr = barChart.getAxisRight();
        //yr.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yr.setDrawGridLines(false);
        yr.setDrawLabels(false);
        yr.setDrawAxisLine(false);
        //yr.setAxisMinimum(0f);
        //yr.setAxisMaximum(high+10f);


        Description description = barChart.getDescription();
        description.setEnabled(false);
        description.setText("");



        Legend l = barChart.getLegend();
        l.setCustom(legendEntries);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);

        barChart.setDescription(description);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.animateY(3000);
        barChart.invalidate();

    }
}