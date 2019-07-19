/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentationRootPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presentation Root Pkg</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentationRootPkgImpl#getPresentationPkgs <em>Presentation Pkgs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PresentationRootPkgImpl extends MinimalEObjectImpl.Container implements PresentationRootPkg
{
	/**
	 * The cached value of the '{@link #getPresentationPkgs() <em>Presentation Pkgs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentationPkgs()
	 * @generated
	 * @ordered
	 */
	protected EList<PresentationPkg<? extends Presentation>> presentationPkgs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentationRootPkgImpl()
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
		return RenderingPackage.Literals.PRESENTATION_ROOT_PKG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PresentationPkg<? extends Presentation>> getPresentationPkgs()
	{
		if (presentationPkgs == null)
		{
			presentationPkgs = new EObjectContainmentEList<PresentationPkg<? extends Presentation>>(PresentationPkg.class, this, RenderingPackage.PRESENTATION_ROOT_PKG__PRESENTATION_PKGS);
		}
		return presentationPkgs;
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
			case RenderingPackage.PRESENTATION_ROOT_PKG__PRESENTATION_PKGS:
				return ((InternalEList<?>)getPresentationPkgs()).basicRemove(otherEnd, msgs);
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
			case RenderingPackage.PRESENTATION_ROOT_PKG__PRESENTATION_PKGS:
				return getPresentationPkgs();
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
			case RenderingPackage.PRESENTATION_ROOT_PKG__PRESENTATION_PKGS:
				getPresentationPkgs().clear();
				getPresentationPkgs().addAll((Collection<? extends PresentationPkg<? extends Presentation>>)newValue);
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
			case RenderingPackage.PRESENTATION_ROOT_PKG__PRESENTATION_PKGS:
				getPresentationPkgs().clear();
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
			case RenderingPackage.PRESENTATION_ROOT_PKG__PRESENTATION_PKGS:
				return presentationPkgs != null && !presentationPkgs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PresentationRootPkgImpl
