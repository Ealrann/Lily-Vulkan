/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.vulkan.extra.model.rendering.GenericVertexProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generic Vertex Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class GenericVertexProviderImpl<T extends Presentation> extends GenericDataProviderImpl<T> implements GenericVertexProvider<T>
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GenericVertexProviderImpl()
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
		return RenderingPackage.Literals.GENERIC_VERTEX_PROVIDER;
	}

} //GenericVertexProviderImpl
