package org.sheepy.lily.vulkan.extra.model.nuklear;

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
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.FontImageProviderBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;

public interface FontImageProvider extends ImageDataProvider {
  static Builder builder() {
    return new FontImageProviderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  NuklearFont nuklearFont();
  void nuklearFont(final NuklearFont nuklearFont);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int NUKLEAR_FONT = 1054784896;
  }

  interface Features<T extends Features<T>> extends ImageDataProvider.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<NuklearFont, NuklearFont, Listener<NuklearFont>, Features<?>> NUKLEAR_FONT = new RelationBuilder<NuklearFont, NuklearFont, Listener<NuklearFont>, Features<?>>().name("nuklearFont").mandatory(true).id(FontImageProvider.FeatureIDs.NUKLEAR_FONT).concept(() -> NuklearModelDefinition.Groups.NUKLEAR_FONT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, NUKLEAR_FONT);
  }

  interface Builder extends IFeaturedObject.Builder<FontImageProvider> {
    Builder name(String name);
    Builder nuklearFont(Supplier<NuklearFont> nuklearFont);
  }
}
