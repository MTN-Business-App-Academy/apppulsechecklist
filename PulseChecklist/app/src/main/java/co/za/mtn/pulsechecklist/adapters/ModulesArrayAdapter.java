package co.za.mtn.pulsechecklist.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import co.za.mtn.pulsechecklist.R;
import co.za.mtn.pulsechecklist.data.Module;

public class ModulesArrayAdapter extends ArrayAdapter<Module> {
    private Context context;
    private Module[] modules;
    public ModulesArrayAdapter(@NonNull Context context, int resource, @NonNull Module[] modules){
        super(context, resource, modules);
        this.context = context;
        this.modules = modules;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.layout_module_item_view, parent, false);

        Module module = modules[position];

        ImageView modulePicture = rowView.findViewById(R.id.modulePicture);
        TextView moduleName = rowView.findViewById(R.id.moduleName);
        TextView label = rowView.findViewById(R.id.moduleLabel);

        moduleName.setText(module.getName());
        modulePicture.setImageResource(module.getImageReference());
        label.setText(module.getLabel());

        return rowView;
    }
}
