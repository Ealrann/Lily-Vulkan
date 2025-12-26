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
import org.sheepy.lily.core.model.presentation.IPresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.IEntityResolver;
import org.sheepy.lily.vulkan.extra.model.sprite.builder.SpritePkgBuilder;

public interface SpritePkg extends ISpriteDataSource, IEntityResolver, IPresentationPkg {
  static Builder builder() {
    return new SpritePkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Sprite> sprites();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SPRITES = -661591782;
  }

  interface Features<T extends Features<T>> extends ISpriteDataSource.Features<T>, IEntityResolver.Features<T>, IPresentationPkg.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<Sprite, List<Sprite>, Listener<List<Sprite>>, Features<?>> SPRITES = new RelationBuilder<Sprite, List<Sprite>, Listener<List<Sprite>>, Features<?>>().name("sprites").many(true).contains(true).id(SpritePkg.FeatureIDs.SPRITES).concept(() -> SpriteModelDefinition.Groups.SPRITE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SPRITES);
  }

  interface Builder extends IFeaturedObject.Builder<SpritePkg> {
    Builder name(String name);
    Builder addSprite(Supplier<Sprite> sprite);
    Builder addSprites(List<Sprite> sprites);
  }
}
