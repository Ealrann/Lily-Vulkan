/**
 */
package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPackage;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshPkg;

import org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationPkgImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pkg</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MeshPkgImpl extends PresentationPkgImpl<Mesh> implements MeshPkg
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MeshPkgImpl()
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
		return MeshPackage.Literals.MESH_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * This is specialized for the more specific element type known in this context.
	 * @generated
	 */
	@Override
	public EList<Mesh> getPresentations()
	{
		if (presentations == null)
		{
			presentations = new EObjectContainmentEList<Mesh>(Mesh.class, this, MeshPackage.MESH_PKG__PRESENTATIONS);
		}
		return presentations;
	}

} //MeshPkgImpl
