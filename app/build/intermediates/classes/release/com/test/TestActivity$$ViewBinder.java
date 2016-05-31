// Generated code from Butter Knife. Do not modify!
package com.test;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class TestActivity$$ViewBinder<T extends com.test.TestActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131361807, "field 'tv'");
    target.tv = finder.castView(view, 2131361807, "field 'tv'");
    view = finder.findRequiredView(source, 2131361808, "field 'bt' and method 'onClick'");
    target.bt = finder.castView(view, 2131361808, "field 'bt'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onClick();
        }
      });
  }

  @Override public void unbind(T target) {
    target.tv = null;
    target.bt = null;
  }
}
