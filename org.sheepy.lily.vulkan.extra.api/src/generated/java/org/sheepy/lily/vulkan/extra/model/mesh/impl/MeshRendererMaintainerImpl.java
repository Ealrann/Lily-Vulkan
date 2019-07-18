/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.ecore.EClass;

import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshRendererMaintainer;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.GenericRendererMaintainerImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renderer Maintainer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MeshRendererMaintainerImpl extends GenericRendererMaintainerImpl<Mesh> implements MeshRendererMaintainer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeshRendererMaintainerImpl()
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
		return MeshPackage.Literals.MESH_RENDERER_MAINTAINER;
	}

} //MeshRendererMaintainerImpl
