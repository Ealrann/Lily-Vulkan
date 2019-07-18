/**
 */
package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePackage;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePipelineMaintainer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pipeline Maintainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class SpritePipelineMaintainerImpl extends GenericRendererMaintainerImpl<Sprite> implements SpritePipelineMaintainer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SpritePipelineMaintainerImpl()
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
		return SpritePackage.Literals.SPRITE_PIPELINE_MAINTAINER;
	}

} //SpritePipelineMaintainerImpl
