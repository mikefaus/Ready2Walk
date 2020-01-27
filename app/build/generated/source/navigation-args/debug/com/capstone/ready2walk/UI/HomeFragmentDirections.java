package com.capstone.ready2walk.UI;

import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.capstone.ready2walk.R;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionStartSampling() {
    return new ActionOnlyNavDirections(R.id.actionStartSampling);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToFilesFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_filesFragment);
  }
}
