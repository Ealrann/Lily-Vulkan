/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Presentable Entity</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl#getPresentation <em>Presentation</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.PresentableEntityImpl#getScale <em>Scale</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PresentableEntityImpl extends PhysicalEntityImpl implements PresentableEntity
{
	/**
	 * The cached value of the '{@link #getPresentation() <em>Presentation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPresentation()
	 * @generated
	 * @ordered
	 */
	protected Presentation presentation;

	/**
	 * The default value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected static final double SCALE_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getScale() <em>Scale</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScale()
	 * @generated
	 * @ordered
	 */
	protected double scale = SCALE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PresentableEntityImpl()
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
		return RenderingPackage.Literals.PRESENTABLE_ENTITY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Presentation getPresentation()
	{
		if (presentation != null && ((EObject)presentation).eIsProxy())
		{
			InternalEObject oldPresentation = (InternalEObject)presentation;
			presentation = (Presentation)eResolveProxy(oldPresentation);
			if (presentation != oldPresentation)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION, oldPresentation, presentation));
			}
		}
		return presentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Presentation basicGetPresentation()
	{
		return presentation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPresentation(Presentation newPresentation, NotificationChain msgs)
	{
		Presentation oldPresentation = presentation;
		presentation = newPresentation;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION, oldPresentation, newPresentation);
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
	public void setPresentation(Presentation newPresentation)
	{
		if (newPresentation != presentation)
		{
			NotificationChain msgs = null;
			if (presentation != null)
				msgs = ((InternalEObject)presentation).eInverseRemove(this, RenderingPackage.PRESENTATION__PRESENTED_ENTITIES, Presentation.class, msgs);
			if (newPresentation != null)
				msgs = ((InternalEObject)newPresentation).eInverseAdd(this, RenderingPackage.PRESENTATION__PRESENTED_ENTITIES, Presentation.class, msgs);
			msgs = basicSetPresentation(newPresentation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION, newPresentation, newPresentation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public double getScale()
	{
		return scale;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setScale(double newScale)
	{
		double oldScale = scale;
		scale = newScale;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.PRESENTABLE_ENTITY__SCALE, oldScale, scale));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID)
		{
			case RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION:
				if (presentation != null)
					msgs = ((InternalEObject)presentation).eInverseRemove(this, RenderingPackage.PRESENTATION__PRESENTED_ENTITIES, Presentation.class, msgs);
				return basicSetPresentation((Presentation)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
			case RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION:
				return basicSetPresentation(null, msgs);
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
			case RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION:
				if (resolve) return getPresentation();
				return basicGetPresentation();
			case RenderingPackage.PRESENTABLE_ENTITY__SCALE:
				return getScale();
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
		switch (featureID)
		{
			case RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION:
				setPresentation((Presentation)newValue);
				return;
			case RenderingPackage.PRESENTABLE_ENTITY__SCALE:
				setScale((Double)newValue);
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
			case RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION:
				setPresentation((Presentation)null);
				return;
			case RenderingPackage.PRESENTABLE_ENTITY__SCALE:
				setScale(SCALE_EDEFAULT);
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
			case RenderingPackage.PRESENTABLE_ENTITY__PRESENTATION:
				return presentation != null;
			case RenderingPackage.PRESENTABLE_ENTITY__SCALE:
				return scale != SCALE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (scale: ");
		result.append(scale);
		result.append(')');
		return result.toString();
	}

} //PresentableEntityImpl
