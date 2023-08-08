/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickConstants;
import org.sheepy.lily.vulkan.extra.model.rendering.MousePickExtension;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mouse Pick Constants</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.MousePickConstantsImpl#getMousePickExtension <em>Mouse Pick Extension</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MousePickConstantsImpl extends ConstantBufferImpl implements MousePickConstants
{
	/**
	 * The cached value of the '{@link #getMousePickExtension() <em>Mouse Pick Extension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMousePickExtension()
	 * @generated
	 * @ordered
	 */
	protected MousePickExtension mousePickExtension;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MousePickConstantsImpl()
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
		return RenderingPackage.Literals.MOUSE_PICK_CONSTANTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MousePickExtension getMousePickExtension()
	{
		if (mousePickExtension != null && ((EObject)mousePickExtension).eIsProxy())
		{
			InternalEObject oldMousePickExtension = mousePickExtension;
			mousePickExtension = (MousePickExtension)eResolveProxy(oldMousePickExtension);
			if (mousePickExtension != oldMousePickExtension)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.MOUSE_PICK_CONSTANTS__MOUSE_PICK_EXTENSION, oldMousePickExtension, mousePickExtension));
			}
		}
		return mousePickExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MousePickExtension basicGetMousePickExtension()
	{
		return mousePickExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMousePickExtension(MousePickExtension newMousePickExtension)
	{
		MousePickExtension oldMousePickExtension = mousePickExtension;
		mousePickExtension = newMousePickExtension;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.MOUSE_PICK_CONSTANTS__MOUSE_PICK_EXTENSION, oldMousePickExtension, mousePickExtension));
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
			case RenderingPackage.MOUSE_PICK_CONSTANTS__MOUSE_PICK_EXTENSION:
				if (resolve) return getMousePickExtension();
				return basicGetMousePickExtension();
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
			case RenderingPackage.MOUSE_PICK_CONSTANTS__MOUSE_PICK_EXTENSION:
				setMousePickExtension((MousePickExtension)newValue);
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
			case RenderingPackage.MOUSE_PICK_CONSTANTS__MOUSE_PICK_EXTENSION:
				setMousePickExtension((MousePickExtension)null);
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
			case RenderingPackage.MOUSE_PICK_CONSTANTS__MOUSE_PICK_EXTENSION:
				return mousePickExtension != null;
		}
		return super.eIsSet(featureID);
	}

} //MousePickConstantsImpl
