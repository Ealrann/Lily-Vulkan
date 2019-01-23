/**
 */
package org.sheepy.lily.vulkan.demo.model.impl;

import org.eclipse.emf.ecore.EClass;
import org.sheepy.lily.vulkan.demo.model.MeshBuffer;
import org.sheepy.lily.vulkan.demo.model.VulkanDemoPackage;
import org.sheepy.lily.vulkan.model.resource.impl.IndexedBufferImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mesh Buffer</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MeshBufferImpl extends IndexedBufferImpl implements MeshBuffer
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeshBufferImpl()
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
		return VulkanDemoPackage.Literals.MESH_BUFFER;
	}

} //MeshBufferImpl
