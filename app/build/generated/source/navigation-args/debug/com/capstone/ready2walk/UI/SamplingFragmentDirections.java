package com.capstone.ready2walk.UI;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.capstone.ready2walk.R;

public class SamplingFragmentDirections {
  private SamplingFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionSaveSampling() {
    return new ActionOnlyNavDirections(R.id.actionSaveSampling);
  }
}
