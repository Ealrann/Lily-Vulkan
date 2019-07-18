/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl;

import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteRendererMaintainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renderer Maintainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SpriteRendererMaintainerImpl extends GenericRendererMaintainerImpl<Sprite> implements SpriteRendererMaintainer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpriteRendererMaintainerImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SpritePackage.Literals.SPRITE_RENDERER_MAINTAINER;
	}

} //SpriteRendererMaintainerImpl
