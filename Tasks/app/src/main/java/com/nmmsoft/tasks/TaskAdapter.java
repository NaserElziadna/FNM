package com.nmmsoft.tasks;

import com.nmmsoft.tasks.Model.Task;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context mContext;
    private int mResource;
    private Task mtask;

    public TaskAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Task> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mResource = resource;
    }

    @Nullable
    @Override
    public Task getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource, parent, false);

        ImageView imageView = convertView.findViewById(R.id.image);
        TextView txtSub = convertView.findViewById(R.id.subject);
        TextView txtDes = convertView.findViewById(R.id.description);

        imageView.setImageResource(getItem(position).getImage());
        txtSub.setText(getItem(position).getSubject());
        txtDes.setText(getItem(position).getDescription());

        switch (getItem(position).getPriority()) {
            case EASY_PRIORITY:
                convertView.setBackgroundColor(Color.GREEN);
                break;
            case MEDIUM_PRIORITY:
                convertView.setBackgroundColor(Color.BLUE);
                break;
            case HARD_PRIORITY:
                convertView.setBackgroundColor(Color.RED);
                break;
            default:
                convertView.setBackgroundColor(Color.GRAY);
                break;
        }

        return convertView;
    }

}
