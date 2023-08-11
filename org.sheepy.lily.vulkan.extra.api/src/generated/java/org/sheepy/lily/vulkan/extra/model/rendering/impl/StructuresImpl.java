/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structures;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Structures</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.StructuresImpl#getStructurePkgs <em>Structure Pkgs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StructuresImpl extends LilyEObject implements Structures
{
	/**
	 * The cached value of the '{@link #getStructurePkgs() <em>Structure Pkgs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStructurePkgs()
	 * @generated
	 * @ordered
	 */
	protected EList<StructurePkg> structurePkgs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StructuresImpl()
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
		return RenderingPackage.Literals.STRUCTURES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<StructurePkg> getStructurePkgs()
	{
		if (structurePkgs == null)
		{
			structurePkgs = new EObjectContainmentEList<>(StructurePkg.class, this, RenderingPackage.STRUCTURES__STRUCTURE_PKGS);
		}
		return structurePkgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case RenderingPackage.STRUCTURES__STRUCTURE_PKGS:
				return ((InternalEList<?>)getStructurePkgs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case RenderingPackage.STRUCTURES__STRUCTURE_PKGS:
				return getStructurePkgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case RenderingPackage.STRUCTURES__STRUCTURE_PKGS:
				getStructurePkgs().clear();
				getStructurePkgs().addAll((Collection<? extends StructurePkg>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case RenderingPackage.STRUCTURES__STRUCTURE_PKGS:
				getStructurePkgs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case RenderingPackage.STRUCTURES__STRUCTURE_PKGS:
				return structurePkgs != null && !structurePkgs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StructuresImpl
