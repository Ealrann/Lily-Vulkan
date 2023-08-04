/**
 */
package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Render Proxy Constant Buffer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl#getConstantBuffer <em>Constant Buffer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl#getPartIndex <em>Part Index</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RenderProxyConstantBufferImpl extends ConstantBufferImpl implements RenderProxyConstantBuffer
{
	/**
	 * The cached value of the '{@link #getConstantBuffer() <em>Constant Buffer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstantBuffer()
	 * @generated
	 * @ordered
	 */
	protected ConstantBuffer constantBuffer;

	/**
	 * The default value of the '{@link #getPartIndex() <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int PART_INDEX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getPartIndex() <em>Part Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPartIndex()
	 * @generated
	 * @ordered
	 */
	protected int partIndex = PART_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenderProxyConstantBufferImpl()
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
		return RenderingPackage.Literals.RENDER_PROXY_CONSTANT_BUFFER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConstantBuffer getConstantBuffer()
	{
		if (constantBuffer != null && ((EObject)constantBuffer).eIsProxy())
		{
			InternalEObject oldConstantBuffer = (InternalEObject)constantBuffer;
			constantBuffer = (ConstantBuffer)eResolveProxy(oldConstantBuffer);
			if (constantBuffer != oldConstantBuffer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER, oldConstantBuffer, constantBuffer));
			}
		}
		return constantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstantBuffer basicGetConstantBuffer()
	{
		return constantBuffer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConstantBuffer(ConstantBuffer newConstantBuffer)
	{
		ConstantBuffer oldConstantBuffer = constantBuffer;
		constantBuffer = newConstantBuffer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER, oldConstantBuffer, constantBuffer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getPartIndex()
	{
		return partIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPartIndex(int newPartIndex)
	{
		int oldPartIndex = partIndex;
		partIndex = newPartIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX, oldPartIndex, partIndex));
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
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER:
				if (resolve) return getConstantBuffer();
				return basicGetConstantBuffer();
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX:
				return getPartIndex();
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
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER:
				setConstantBuffer((ConstantBuffer)newValue);
				return;
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX:
				setPartIndex((Integer)newValue);
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
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER:
				setConstantBuffer((ConstantBuffer)null);
				return;
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX:
				setPartIndex(PART_INDEX_EDEFAULT);
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
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__CONSTANT_BUFFER:
				return constantBuffer != null;
			case RenderingPackage.RENDER_PROXY_CONSTANT_BUFFER__PART_INDEX:
				return partIndex != PART_INDEX_EDEFAULT;
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
		result.append(" (partIndex: ");
		result.append(partIndex);
		result.append(')');
		return result.toString();
	}

} //RenderProxyConstantBufferImpl
