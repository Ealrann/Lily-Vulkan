package org.sheepy.lily.vulkan.extra.model.sprite;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.sprite.builder.SpriteBuilder;

public interface Sprite extends Presentation, LNamedElement {
  static Builder builder() {
    return new SpriteBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  FileImage image();
  void image(final FileImage image);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int PRESENTED_ENTITIES = Presentation.FeatureIDs.PRESENTED_ENTITIES;
    int IMAGE = 242838151;
  }

  interface Features<T extends Features<T>> extends Presentation.Features<T>, LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<PresentableEntity, List<PresentableEntity>, Listener<List<PresentableEntity>>, Presentation.Features<?>> PRESENTED_ENTITIES = Presentation.Features.PRESENTED_ENTITIES;
    Relation<FileImage, FileImage, Listener<FileImage>, Features<?>> IMAGE = new RelationBuilder<FileImage, FileImage, Listener<FileImage>, Features<?>>().name("image").mandatory(true).contains(true).id(Sprite.FeatureIDs.IMAGE).concept(() -> ResourceModelDefinition.Groups.FILE_IMAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, PRESENTED_ENTITIES, IMAGE);
  }

  interface Builder extends IFeaturedObject.Builder<Sprite> {
    Builder name(String name);
    Builder addPresentedEntitie(Supplier<PresentableEntity> presentedEntitie);
    Builder image(Supplier<FileImage> image);
    Builder addPresentedEntities(List<PresentableEntity> presentedEntities);
  }
}
