/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.sheepy.lily.core.api.model.LilyEObject;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;

import org.sheepy.vulkan.model.enumeration.EInputRate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.InputDescriptorImpl#getInputRate <em>Input Rate</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.InputDescriptorImpl#getStrideLength <em>Stride Length</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.InputDescriptorImpl#getAttributes <em>Attributes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InputDescriptorImpl extends LilyEObject implements InputDescriptor
{
	/**
	 * The default value of the '{@link #getInputRate() <em>Input Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputRate()
	 * @generated
	 * @ordered
	 */
	protected static final EInputRate INPUT_RATE_EDEFAULT = EInputRate.VERTEX;

	/**
	 * The cached value of the '{@link #getInputRate() <em>Input Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputRate()
	 * @generated
	 * @ordered
	 */
	protected EInputRate inputRate = INPUT_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStrideLength() <em>Stride Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrideLength()
	 * @generated
	 * @ordered
	 */
	protected static final int STRIDE_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStrideLength() <em>Stride Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStrideLength()
	 * @generated
	 * @ordered
	 */
	protected int strideLength = STRIDE_LENGTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<AttributeDescription> attributes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputDescriptorImpl()
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
		return GraphicPackage.Literals.INPUT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EInputRate getInputRate()
	{
		return inputRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputRate(EInputRate newInputRate)
	{
		EInputRate oldInputRate = inputRate;
		inputRate = newInputRate == null ? INPUT_RATE_EDEFAULT : newInputRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.INPUT_DESCRIPTOR__INPUT_RATE, oldInputRate, inputRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStrideLength()
	{
		return strideLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStrideLength(int newStrideLength)
	{
		int oldStrideLength = strideLength;
		strideLength = newStrideLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicPackage.INPUT_DESCRIPTOR__STRIDE_LENGTH, oldStrideLength, strideLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<AttributeDescription> getAttributes()
	{
		if (attributes == null)
		{
			attributes = new EObjectContainmentEList<AttributeDescription>(AttributeDescription.class, this, GraphicPackage.INPUT_DESCRIPTOR__ATTRIBUTES);
		}
		return attributes;
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
			case GraphicPackage.INPUT_DESCRIPTOR__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
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
			case GraphicPackage.INPUT_DESCRIPTOR__INPUT_RATE:
				return getInputRate();
			case GraphicPackage.INPUT_DESCRIPTOR__STRIDE_LENGTH:
				return getStrideLength();
			case GraphicPackage.INPUT_DESCRIPTOR__ATTRIBUTES:
				return getAttributes();
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
			case GraphicPackage.INPUT_DESCRIPTOR__INPUT_RATE:
				setInputRate((EInputRate)newValue);
				return;
			case GraphicPackage.INPUT_DESCRIPTOR__STRIDE_LENGTH:
				setStrideLength((Integer)newValue);
				return;
			case GraphicPackage.INPUT_DESCRIPTOR__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends AttributeDescription>)newValue);
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
			case GraphicPackage.INPUT_DESCRIPTOR__INPUT_RATE:
				setInputRate(INPUT_RATE_EDEFAULT);
				return;
			case GraphicPackage.INPUT_DESCRIPTOR__STRIDE_LENGTH:
				setStrideLength(STRIDE_LENGTH_EDEFAULT);
				return;
			case GraphicPackage.INPUT_DESCRIPTOR__ATTRIBUTES:
				getAttributes().clear();
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
			case GraphicPackage.INPUT_DESCRIPTOR__INPUT_RATE:
				return inputRate != INPUT_RATE_EDEFAULT;
			case GraphicPackage.INPUT_DESCRIPTOR__STRIDE_LENGTH:
				return strideLength != STRIDE_LENGTH_EDEFAULT;
			case GraphicPackage.INPUT_DESCRIPTOR__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
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
		result.append(" (inputRate: ");
		result.append(inputRate);
		result.append(", strideLength: ");
		result.append(strideLength);
		result.append(')');
		return result.toString();
	}

} //InputDescriptorImpl
