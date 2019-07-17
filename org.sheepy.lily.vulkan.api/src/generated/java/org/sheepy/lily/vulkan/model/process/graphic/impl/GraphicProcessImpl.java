/**
 */
package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerPackage;

import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPassInfo;

import org.sheepy.lily.vulkan.model.process.impl.AbstractProcessImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getMaintainer <em>Maintainer</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getRenderPassInfo <em>Render Pass Info</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl#getFieldOfViewY <em>Field Of View Y</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GraphicProcessImpl extends AbstractProcessImpl implements GraphicProcess
{
	/**
	 * The cached value of the '{@link #getMaintainer() <em>Maintainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaintainer()
	 * @generated
	 * @ordered
	 */
	protected Maintainer<GraphicProcess> maintainer;

	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected GraphicConfiguration configuration;

	/**
	 * The cached value of the '{@link #getRenderPassInfo() <em>Render Pass Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenderPassInfo()
	 * @generated
	 * @ordered
	 */
	protected RenderPassInfo renderPassInfo;

	/**
	 * The default value of the '{@link #getFieldOfViewY() <em>Field Of View Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldOfViewY()
	 * @generated
	 * @ordered
	 */
	protected static final float FIELD_OF_VIEW_Y_EDEFAULT = 45.0F;

	/**
	 * The cached value of the '{@link #getFieldOfViewY() <em>Field Of View Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldOfViewY()
	 * @generated
	 * @ordered
	 */
	protected float fieldOfViewY = FIELD_OF_VIEW_Y_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GraphicProcessImpl()
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
		return GraphicPackage.Literals.GRAPHIC_PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Maintainer<GraphicProcess> getMaintainer()
	{
		if (maintainer != null && maintainer.eIsProxy())
		{
			InternalEObject oldMaintainer = (InternalEObject) maintainer;
			maintainer = (Maintainer<GraphicProcess>) eResolveProxy(oldMaintainer);
			if (maintainer != oldMaintainer)
			{
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							GraphicPackage.GRAPHIC_PROCESS__MAINTAINER, oldMaintainer, maintainer));
			}
		}
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Maintainer<GraphicProcess> basicGetMaintainer()
	{
		return maintainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMaintainer(Maintainer<GraphicProcess> newMaintainer,
												NotificationChain msgs)
	{
		Maintainer<GraphicProcess> oldMaintainer = maintainer;
		maintainer = newMaintainer;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_PROCESS__MAINTAINER, oldMaintainer, newMaintainer);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaintainer(Maintainer<GraphicProcess> newMaintainer)
	{
		if (newMaintainer != maintainer)
		{
			NotificationChain msgs = null;
			if (maintainer != null) msgs = ((InternalEObject) maintainer).eInverseRemove(this,
					MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			if (newMaintainer != null) msgs = ((InternalEObject) newMaintainer).eInverseAdd(this,
					MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			msgs = basicSetMaintainer(newMaintainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__MAINTAINER, newMaintainer, newMaintainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GraphicConfiguration getConfiguration()
	{
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(	GraphicConfiguration newConfiguration,
													NotificationChain msgs)
	{
		GraphicConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, oldConfiguration,
					newConfiguration);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConfiguration(GraphicConfiguration newConfiguration)
	{
		if (newConfiguration != configuration)
		{
			NotificationChain msgs = null;
			if (configuration != null) msgs = ((InternalEObject) configuration).eInverseRemove(this,
					EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, null,
					msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject) newConfiguration).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION,
						null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RenderPassInfo getRenderPassInfo()
	{
		return renderPassInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenderPassInfo(RenderPassInfo newRenderPassInfo,
													NotificationChain msgs)
	{
		RenderPassInfo oldRenderPassInfo = renderPassInfo;
		renderPassInfo = newRenderPassInfo;
		if (eNotificationRequired())
		{
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO, oldRenderPassInfo,
					newRenderPassInfo);
			if (msgs == null) msgs = notification;
			else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRenderPassInfo(RenderPassInfo newRenderPassInfo)
	{
		if (newRenderPassInfo != renderPassInfo)
		{
			NotificationChain msgs = null;
			if (renderPassInfo != null)
				msgs = ((InternalEObject) renderPassInfo).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO,
						null, msgs);
			if (newRenderPassInfo != null)
				msgs = ((InternalEObject) newRenderPassInfo).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO,
						null, msgs);
			msgs = basicSetRenderPassInfo(newRenderPassInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO, newRenderPassInfo,
				newRenderPassInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getFieldOfViewY()
	{
		return fieldOfViewY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldOfViewY(float newFieldOfViewY)
	{
		float oldFieldOfViewY = fieldOfViewY;
		fieldOfViewY = newFieldOfViewY;
		if (eNotificationRequired()) eNotify(new ENotificationImpl(this, Notification.SET,
				GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y, oldFieldOfViewY, fieldOfViewY));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(	InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
			if (maintainer != null) msgs = ((InternalEObject) maintainer).eInverseRemove(this,
					MaintainerPackage.MAINTAINER__MAINTAINED, Maintainer.class, msgs);
			return basicSetMaintainer((Maintainer<GraphicProcess>) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
											int featureID,
											NotificationChain msgs)
	{
		switch (featureID)
		{
		case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
			return basicSetMaintainer(null, msgs);
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			return basicSetConfiguration(null, msgs);
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			return basicSetRenderPassInfo(null, msgs);
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
		case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
			if (resolve) return getMaintainer();
			return basicGetMaintainer();
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			return getConfiguration();
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			return getRenderPassInfo();
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			return getFieldOfViewY();
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
		case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
			setMaintainer((Maintainer<GraphicProcess>) newValue);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			setConfiguration((GraphicConfiguration) newValue);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			setRenderPassInfo((RenderPassInfo) newValue);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			setFieldOfViewY((Float) newValue);
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
		case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
			setMaintainer((Maintainer<GraphicProcess>) null);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			setConfiguration((GraphicConfiguration) null);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			setRenderPassInfo((RenderPassInfo) null);
			return;
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			setFieldOfViewY(FIELD_OF_VIEW_Y_EDEFAULT);
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
		case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
			return maintainer != null;
		case GraphicPackage.GRAPHIC_PROCESS__CONFIGURATION:
			return configuration != null;
		case GraphicPackage.GRAPHIC_PROCESS__RENDER_PASS_INFO:
			return renderPassInfo != null;
		case GraphicPackage.GRAPHIC_PROCESS__FIELD_OF_VIEW_Y:
			return fieldOfViewY != FIELD_OF_VIEW_Y_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
	{
		if (baseClass == Maintainable.class)
		{
			switch (derivedFeatureID)
			{
			case GraphicPackage.GRAPHIC_PROCESS__MAINTAINER:
				return MaintainerPackage.MAINTAINABLE__MAINTAINER;
			default:
				return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
	{
		if (baseClass == Maintainable.class)
		{
			switch (baseFeatureID)
			{
			case MaintainerPackage.MAINTAINABLE__MAINTAINER:
				return GraphicPackage.GRAPHIC_PROCESS__MAINTAINER;
			default:
				return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (fieldOfViewY: ");
		result.append(fieldOfViewY);
		result.append(')');
		return result.toString();
	}

} //GraphicProcessImpl
