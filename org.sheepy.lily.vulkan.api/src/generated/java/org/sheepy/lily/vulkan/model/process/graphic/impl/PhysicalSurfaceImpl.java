/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.lily.vulkan.model.process.graphic.ColorDomain;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.PhysicalSurface;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Physical Surface</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.PhysicalSurfaceImpl#getColorDomain <em>Color Domain</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PhysicalSurfaceImpl extends LilyEObject implements PhysicalSurface
{
	/**
	 * The cached value of the '{@link #getColorDomain() <em>Color Domain</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getColorDomain()
	 * @generated
	 * @ordered
	 */
	protected ColorDomain colorDomain;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PhysicalSurfaceImpl()
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
		return GraphicPackage.Literals.PHYSICAL_SURFACE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ColorDomain getColorDomain()
	{
		return colorDomain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetColorDomain(ColorDomain newColorDomain, NotificationChain msgs)
	{
		ColorDomain oldColorDomain = colorDomain;
		colorDomain = newColorDomain;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN, oldColorDomain, newColorDomain);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setColorDomain(ColorDomain newColorDomain)
	{
		if (newColorDomain != colorDomain) {
			NotificationChain msgs = null;
			if (colorDomain != null)
				msgs = ((InternalEObject)colorDomain).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN, null, msgs);
			if (newColorDomain != null)
				msgs = ((InternalEObject)newColorDomain).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN, null, msgs);
			msgs = basicSetColorDomain(newColorDomain, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN, newColorDomain, newColorDomain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN:
				return basicSetColorDomain(null, msgs);
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
		switch (featureID) {
			case GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN:
				return getColorDomain();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN:
				setColorDomain((ColorDomain)newValue);
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
		switch (featureID) {
			case GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN:
				setColorDomain((ColorDomain)null);
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
		switch (featureID) {
			case GraphicPackage.PHYSICAL_SURFACE__COLOR_DOMAIN:
				return colorDomain != null;
		}
		return super.eIsSet(featureID);
	}

} //PhysicalSurfaceImpl
