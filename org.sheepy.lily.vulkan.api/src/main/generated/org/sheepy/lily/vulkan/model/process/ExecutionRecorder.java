package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface ExecutionRecorder extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Submission submission();
  void submission(final Submission submission);

  interface FeatureIDs {
    int SUBMISSION = -39450671;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Submission, Submission, Listener<Submission>, Features<?>> SUBMISSION = new RelationBuilder<Submission, Submission, Listener<Submission>, Features<?>>().name("submission").mandatory(true).contains(true).id(ExecutionRecorder.FeatureIDs.SUBMISSION).concept(() -> ProcessModelDefinition.Groups.SUBMISSION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(SUBMISSION);
  }
}
